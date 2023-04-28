package com.vass.service.impl;


import com.vass.entities.ClienteEntity;
import com.vass.modelo.ClienteDto;
import com.vass.modelo.ResponseDto;
import com.vass.repository.ClienteRepository;
import com.vass.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *Logica del negocio
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     *Metodo obtencion de todos los clientes.
     * @return Todos los Clientes en base de datos.
     */
    @Override
    public ResponseDto findAll() {

        List<ClienteEntity> entityList = clienteRepository.findAll();

        List<ClienteDto> dtoList = new ArrayList<>();
        for (ClienteEntity clienteEntity : entityList) {
            dtoList.add(ClienteDto.builder()
                    .id(clienteEntity.getId())
                    .nombres(clienteEntity.getNombres())
                    .apellidos(clienteEntity.getApellidos())
                    .cedula(clienteEntity.getCedula())
                    .email(clienteEntity.getEmail())
                    .fechaNacimiento(clienteEntity.getFechaNacimiento())
                    .build());
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("OK");
        responseDto.setData(dtoList);

        return responseDto;
    }
    /**
     *Metodo obtencion clientes segun id.
     * @param id para filtrar en base de datos.
     * @return Cliente por id en base de datos.
     */
    @Override
    public ResponseDto findById(Integer id) {

        Optional<ClienteEntity> clientById = clienteRepository.findById(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("OK");
        if (clientById.isPresent()) {
            ClienteDto clienteDto = ClienteDto.builder()
                    .id(clientById.get().getId())
                    .nombres(clientById.get().getNombres())
                    .apellidos(clientById.get().getApellidos())
                    .cedula(clientById.get().getCedula())
                    .email(clientById.get().getEmail())
                    .fechaNacimiento(clientById.get().getFechaNacimiento())
                    .build();

            responseDto.setData(clienteDto);

        } else {
            responseDto.setStatus("ERROR");
            responseDto.setMessage("No se encontro cliente por id");
        }
        return responseDto;
    }
    /**
     *Metodo obtencion clientes segun cedula.
     * @param cedula para filtrar en base de datos.
     * @return Cliente por id en base de datos.
     */
    @Override
    public ResponseDto findByCedula(String cedula) {

        Optional<ClienteEntity> clienteByCedula = clienteRepository.findByCedula(cedula);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("OK");
        if (clienteByCedula.isPresent()) {
            ClienteDto clienteDto = ClienteDto.builder()
                    .id(clienteByCedula.get().getId())
                    .nombres(clienteByCedula.get().getNombres())
                    .apellidos(clienteByCedula.get().getApellidos())
                    .cedula(clienteByCedula.get().getCedula())
                    .email(clienteByCedula.get().getEmail())
                    .fechaNacimiento(clienteByCedula.get().getFechaNacimiento())
                    .build();

            responseDto.setData(clienteDto);

        } else {
            responseDto.setStatus("ERROR");
            responseDto.setMessage("No se encontro cliente por cedula");
        }
        return responseDto;
    }
    /**
     *Metodo Creacion de  cliente, que no tenga Cedula repetida en base de datos.
     * @param clienteDtoToSave cliente para crear.
     */
    @Override
    public ResponseDto create(ClienteDto clienteDtoToSave) {
        ResponseDto responseDto = new ResponseDto();


        Optional<ClienteEntity> clienteByCedula = clienteRepository.findByCedula(clienteDtoToSave.getCedula());
        if (clienteByCedula.isEmpty()) {
            ClienteEntity clienteEntityToSave = ClienteEntity.builder()
                    .nombres(clienteDtoToSave.getNombres())
                    .apellidos(clienteDtoToSave.getApellidos())
                    .cedula(clienteDtoToSave.getCedula())
                    .email(clienteDtoToSave.getEmail())
                    .fechaNacimiento(clienteDtoToSave.getFechaNacimiento())
                    .build();

            ClienteEntity clienteSaved = clienteRepository.save(clienteEntityToSave);
            clienteDtoToSave.setId(clienteSaved.getId());
            responseDto.setStatus("OK");
            responseDto.setData(clienteDtoToSave);
        } else {

            responseDto.setStatus("ERROR");
            responseDto.setMessage("Ya existe un cliente registrado con la misma cedula");
        }


        return responseDto;
    }

    /**
     *Metodo Actualizacion de clientes.
     * @param id  para filtrar cliente a Actulizar
     * @param clienteDtoToUpdate  informacion de cliente actualizar
      */
    @Override
    public ResponseDto updateById(Integer id, ClienteDto clienteDtoToUpdate) {

        Optional<ClienteEntity> clientById = clienteRepository.findById(id);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("OK");

        if (clientById.isPresent()) {
            ClienteEntity clienteEntity = clientById.get();
            clienteEntity.setNombres(clienteDtoToUpdate.getNombres());
            clienteEntity.setApellidos(clienteDtoToUpdate.getApellidos());
            clienteEntity.setFechaNacimiento(clienteDtoToUpdate.getFechaNacimiento());
            clienteEntity.setEmail(clienteDtoToUpdate.getEmail());

            clienteRepository.save(clienteEntity);

            responseDto.setData(clienteDtoToUpdate);

        } else {
            responseDto.setStatus("ERROR");
            responseDto.setMessage("No se encontro cliente por id");

        }

        return responseDto;
    }
    /**
     *Metodo eliminar cliente segun id.
     * @param id  para filtrar cliente a eliminar
      */
    @Override
    public ResponseDto deleteById(Integer id) {


        Optional<ClienteEntity> clientById = clienteRepository.findById(id);
        ResponseDto responseDto = new ResponseDto();


        if (clientById.isPresent()) {

            clienteRepository.deleteById(clientById.get().getId());

        } else {
            responseDto.setStatus("ERROR");
            responseDto.setMessage("No se encontro cliente por id");

        }

        return responseDto;


    }
    /**
     *Metodo eliminar cliente segun cedula.
     * @param cedula  para filtrar cliente a eliminar
     */
    @Override
    public ResponseDto deletByCedula(String cedula) {


        Optional<ClienteEntity> clientByCedula = clienteRepository.findByCedula(cedula);
        ResponseDto responseDto = new ResponseDto();


        if (clientByCedula.isPresent()) {

            clienteRepository.deleteById(clientByCedula.get().getId());

        } else {
            responseDto.setStatus("ERROR");
            responseDto.setMessage("No se encontro cliente por cedula");

        }

        return responseDto;


    }


}
