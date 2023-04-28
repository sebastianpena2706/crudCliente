package com.vass.service;

import com.vass.modelo.ClienteDto;
import com.vass.modelo.ResponseDto;

public interface ClienteService {

    ResponseDto findAll();

    ResponseDto findById(Integer id);
    ResponseDto findByCedula(String cedula);

    ResponseDto create(ClienteDto clienteDtoToSave);

    ResponseDto updateById(Integer id, ClienteDto clienteDtoToUpdate);

    ResponseDto deleteById(Integer id);

    ResponseDto deletByCedula(String cedula);




}
