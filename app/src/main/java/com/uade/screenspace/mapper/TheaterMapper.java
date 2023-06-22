package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.SeatsLayout;
import io.screenspace.model.Theater;

public class TheaterMapper {

    public static com.uade.screenspace.entity.Theater modelToEntity(Theater modelTheater){
        return new com.uade.screenspace.entity.Theater(
                modelTheater.getName(),
                modelTheater.getIsTemporarilyClosed(),
                modelTheater.getPricePerFunction(),
                new SeatsLayout(
                        modelTheater.getSeatsLayout().getNumRows(),
                        modelTheater.getSeatsLayout().getNumColumns())
        );
    }

    public static Theater entityToModel(com.uade.screenspace.entity.Theater entityTheater){

        return new Theater()
                .id(entityTheater.getId())
                .name(entityTheater.getName())
                .isTemporarilyClosed(entityTheater.isTemporarilyClosed())
                .pricePerFunction(entityTheater.getPricePerFunction())
                .seatsLayout(new io.screenspace.model.SeatsLayout().numColumns(entityTheater.getSeatsLayout().getNumColumns()).numRows(entityTheater.getSeatsLayout().getNumRows()));

    }

}
