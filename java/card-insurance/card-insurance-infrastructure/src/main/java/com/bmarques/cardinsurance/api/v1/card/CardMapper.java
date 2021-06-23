package com.bmarques.cardinsurance.api.v1.card;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.control.DeepClone;

@Mapper(componentModel = "spring",
        mappingControl = DeepClone.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class CardMapper {
}
