package FinalBoxITR.ApiFinal.modules.clientes.controller;

import FinalBoxITR.ApiFinal.modules.clientes.model.dto.ClienteRequestDTO;
import FinalBoxITR.ApiFinal.modules.clientes.service.ClienteService;
import FinalBoxITR.ApiFinal.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClienteController {
    private final ClienteService service;
    public ClienteController (ClienteService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteRequestDTO>>
     nuevoCliente(@Valid @RequestBody ClienteRequestDTO json){
        try{
            ClienteRequestDTO dto = service.nuevoCliente(json);
            ApiResponse<ClienteRequestDTO> response = new ApiResponse<>(true , "Proceso completado", dto);
            return  ResponseEntity.ok(response);
        } catch (Exception e){
            e.printStackTrace();
            ApiResponse<ClienteRequestDTO> respuestaError = new ApiResponse<>(false, "El proceso de insercion no se pudo completar", json);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteRequestDTO>>> obtenerDatos(){
        try {
            List<ClienteRequestDTO>
                    ApiResponse<List<ClienteRequestDTO>> respuesta Exitosa = new ApiResponse<>(true, "Proceso completado", lista);
            return ResponseEntity.ok(respuestaExitosa);
        } catch (Exception e){
            e.printStackTrace();
            ApiResponse<List<ClienteRequestDTO>> respuestaError = new ApiResponse<>(false, "No se pudo obtener los datos de clientes", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
         }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarDatos (@PathVariable Long id){
        try{
            boolean respuesta = service.eliminarClientes(id);
            if (respuesta){
                ApiResponse<Void> resPuestaExitosa = new ApiResponse<>(true, "El cliente con ID: " + id + "Ha sido eliminado", null);
                return ResponseEntity.status(HttpStatus.NO_CONTENT) body (resPuestaExitosa);
            }
            ApiResponse<Void> noEncontrado = new ApiResponse<>(false, "El cliente con ID: "+ id +"no se encontro", null)
        }
    }
}
