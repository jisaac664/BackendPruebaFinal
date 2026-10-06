package FinalBoxITR.ApiFinal.modules.eventos.controller;

import FinalBoxITR.ApiFinal.modules.eventos.model.dto.EventoRequestDTO;
import FinalBoxITR.ApiFinal.modules.eventos.service.EventoService;
import FinalBoxITR.ApiFinal.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EventoController {
    private final EventoService service;
    public EventoController (EventoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EventoRequestDTO>>
    nuevoCliente(@Valid @RequestBody EventoRequestDTO json){
        try{
            EventoRequestDTO dto = service.nuevoEvento(json);
            ApiResponse<EventoRequestDTO> response = new ApiResponse<>(true , "Proceso completado", dto);
            return  ResponseEntity.ok(response);
        } catch (Exception e){
            e.printStackTrace();
            ApiResponse<EventoRequestDTO> respuestaError = new ApiResponse<>(false, "El proceso de insercion no se pudo completar", json);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EventoRequestDTO>>> obtenerDatos(){
        try {
            List<EventoRequestDTO>
            ApiResponse<List<EventoRequestDTO>> respuesta Exitosa = new ApiResponse<>(true, "Proceso completado", lista);
            return ResponseEntity.ok(respuestaExitosa);
        } catch (Exception e){
            e.printStackTrace();
            ApiResponse<List<EventoRequestDTO>> respuestaError = new ApiResponse<>(false, "No se pudo obtener los datos de clientes", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarDatos (@PathVariable Long id){
        try{
            boolean respuesta = service.eliminarEvento(id);
            if (respuesta){
                ApiResponse<Void> resPuestaExitosa = new ApiResponse<>(true, "El cliente con ID: " + id + "Ha sido eliminado", null);
                return ResponseEntity.status(HttpStatus.NO_CONTENT) body (resPuestaExitosa);
            }
            ApiResponse<Void> noEncontrado = new ApiResponse<>(false, "El cliente con ID: "+ id +"no se encontro", null)
        }
    }
}
