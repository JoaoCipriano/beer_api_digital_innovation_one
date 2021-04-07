package one.digitalinnovation.beerstock.builder;

import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.enums.BeerType;

public class BeetDTOBuilderWithoutBuilderFromLombok {

    BeerDTO beerDTO;

    public static BeetDTOBuilderWithoutBuilderFromLombok builder() {
        BeetDTOBuilderWithoutBuilderFromLombok builder = new BeetDTOBuilderWithoutBuilderFromLombok();
        builder.beerDTO = new BeerDTO();
        return builder;
    }

    public BeetDTOBuilderWithoutBuilderFromLombok id(Long id) {
        beerDTO.setId(id);
        return this;
    }

    public BeetDTOBuilderWithoutBuilderFromLombok name(String name) {
        beerDTO.setName(name);
        return this;
    }

    public BeetDTOBuilderWithoutBuilderFromLombok brand(String brand) {
        beerDTO.setBrand(brand);
        return this;
    }

    public BeetDTOBuilderWithoutBuilderFromLombok max(Integer max) {
        beerDTO.setMax(max);
        return this;
    }

    public BeetDTOBuilderWithoutBuilderFromLombok quantity(Integer quantity) {
        beerDTO.setQuantity(quantity);
        return this;
    }

    public BeetDTOBuilderWithoutBuilderFromLombok type(BeerType type) {
        beerDTO.setType(type);
        return this;
    }

    public BeerDTO build() {
        return this.beerDTO;
    }
}
