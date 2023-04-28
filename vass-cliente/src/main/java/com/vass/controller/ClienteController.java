package com.vass.controller;


import com.vass.modelo.ClienteDto;
import com.vass.modelo.ResponseDto;
import com.vass.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 Endpoints a exponer en el servicio
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    /**
     *Obtencion clientes en base datos
     * @return Todos los clientes registrados en base de datos
     */
    @GetMapping("/")
    public ResponseEntity<ResponseDto<List<ClienteDto>>> findAll() {

        ResponseDto<List<ClienteDto>> listAll = clienteService.findAll();
        return new ResponseEntity<>(listAll, HttpStatus.OK);

    }
    /**
     *Obtencion clientes segun id.
     * @param id
     * @return Cliente filtrado por id en base de datos.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<ClienteDto>> findById(@PathVariable("id") Integer id) {

        ResponseDto<ClienteDto> clientById = clienteService.findById(id);
        return new ResponseEntity<>(clientById, HttpStatus.OK);

    }
    /**
     *Obtencion clientes segun cedula.
     * @param cedula
     * @return Cliente filtrado por cedula en base de datos.
     */
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<ResponseDto<ClienteDto>> findByCedula(@PathVariable("cedula") String cedula) {

        ResponseDto<ClienteDto> clientByCedula = clienteService.findByCedula(cedula);
        return new ResponseEntity<>(clientByCedula, HttpStatus.OK);

    }

    /**
     *Creacion de  clientes.
     * @param clientToSave  Cliente a crear
     */
    @PostMapping("/")
    public ResponseEntity<ResponseDto<ClienteDto>> create(@RequestBody ClienteDto clientToSave) {
        ResponseDto<ClienteDto> clientById = clienteService.create(clientToSave);
        return new ResponseEntity<>(clientById, HttpStatus.CREATED);

    }

    /**
     *Actualizacion de  clientes segun id.
     * @param id de cliente que se requiere actualizar
     * @param clientToUpdate  datos para a actualizar cliente
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<ClienteDto>> updateById(@PathVariable("id") Integer id, @RequestBody ClienteDto clientToUpdate) {
        ResponseDto<ClienteDto> clientById = clienteService.updateById(id, clientToUpdate);

        return new ResponseEntity<>(clientById, HttpStatus.OK);

    }

    /**
     *Eliminacion de  clientes segun id.
     * @param id de cliente que se requiere eliminar de base de datos.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<ClienteDto>> deleteById(@PathVariable("id") Integer id) {
        ResponseDto<ClienteDto> responseDto = clienteService.deleteById(id);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }
    /**
     *Eliminacion de  clientes segun cedula.
     * @param cedula de cliente que se requiere eliminar de base de datos.
     */
    @DeleteMapping("/cedula/{cedula}")
    public ResponseEntity<ResponseDto<ClienteDto>> deletByCedula(@PathVariable("cedula") String cedula) {
        ResponseDto<ClienteDto> responseDto = clienteService.deletByCedula(cedula);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }


}
