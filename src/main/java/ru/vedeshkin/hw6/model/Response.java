package ru.vedeshkin.hw6.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<TData> {

    private ResponseCode code;

    private TData data;

}
