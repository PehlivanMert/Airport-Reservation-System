package dev.pehlivan.airportreservationsystem.service.iml;

import dev.pehlivan.airportreservationsystem.exception.NotFoundException;
import dev.pehlivan.airportreservationsystem.model.Address;
import dev.pehlivan.airportreservationsystem.model.entity.Airport;
import dev.pehlivan.airportreservationsystem.repository.AirportRepository;
import dev.pehlivan.airportreservationsystem.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirport(Integer id) {
        Optional<Airport> byId = airportRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Airport"));
    }

    @Override
    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Integer id, Airport airport) {
        getAirport(id);
        airport.setId(id);
        return airportRepository.save(airport);
    }

    @Override
    public boolean deleteAirport(Integer id) {
        airportRepository.delete(getAirport(id));
        return true;
    }

    // java8 playground again :)
    // ----------------------------------------------------------------------------------

    /* Bu metot, şehir adı belirli bir önekle başlayan adresleri bulup döner. Bu, tüm havaalanlarının adreslerini tarayıp,
    şehir ismi verilen önekle başlayan adresleri listelemeyi amaçlar. */

    private List<Address> getAddressCityStartsWith(String prefix) {
        List<Airport> allAirports = getAllAirports();
        return allAirports.stream()
                .map(Airport::getAddresses)
                .flatMap(Collection::stream)
                .distinct()
                .filter(a -> a.getCity().startsWith(prefix))
                .collect(Collectors.toList());
    }

    // Bu method, şehir ismi belirli bir önekle başlayan adresleri bulup yazdırır.

    private void printAllAddressCityStartsWith(String prefix) {
        List<Address> addressCityStartsWith = getAddressCityStartsWith(prefix);
        addressCityStartsWith.stream()
                .map(address -> address.getCity() + "/" + address.getStreetCode() + "/" +
                        address.getBuildingNo())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // Bu metod, tüm havaalanlarındaki adresleri şehir ve posta kodu olarak tek bir stringde birleştirir.

    private void reduceAddressListToCityNameAndStreetCode() {
        List<Airport> allAirports = getAllAirports();
        String reducedAddressList = allAirports.stream()
                .map(Airport::getAddresses).flatMap(Collection::stream)
                .map(address -> address.getCity() + " " + address.getStreetCode())
                .reduce("", (s1, s2) -> s1 + s2); // reduce ile tüm bu adresleri tek bir stringde birleştirir.

        System.out.println("Reduced address list : " + reducedAddressList);
    }
    // Bu metod, iki havaalanının ilk adreslerini birleştirir ve bir string olarak döner.

    private String getCombinedAddressOfBoth(Airport airport1, Airport airport2) {
        // Airports check here!
        // I assume that there is nothing bad here :) and enjoy with BiFunction sample
        BiFunction<Airport, Airport, String> function = (a1, a2) -> a1.getAddresses().get(0).getCity() + "-" + a1.getAddresses().get(0).getStreetCode()
                + "-------" + a2.getAddresses().get(0).getCity() + "-" + a2.getAddresses().get(0).getStreetCode();

        // Gets combined Address String
        return function.apply(airport1, airport2);
    }

    //Bu metod, verilen bir havaalanı kimliği ile havaalanını alır ve adreslerini ekrana yazdırır.

    private void consumeAirportAddresses(Integer airportId) {
        Airport airport = airportRepository.getById(airportId);

        // Defining a consumer for airport address list
        Consumer<Airport> airportConsumer = air -> air.getAddresses().forEach(System.out::println);
        airportConsumer.accept(airport);

    }
}
