package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.Auth.AuthResponse;
import desarrollo.sprint5.apiresttest.Auth.RegisterRequest;
import desarrollo.sprint5.apiresttest.DTO.ClienteDTO;
import desarrollo.sprint5.apiresttest.DTO.DetallePedidoDTO;
import desarrollo.sprint5.apiresttest.Entity.*;
import desarrollo.sprint5.apiresttest.Enumeration.EstadoCliente;
import desarrollo.sprint5.apiresttest.Enumeration.Role;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.DetallePedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ArticuloManufacturadoService articuloManufacturadoService;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);

    }

    public DetallePedido addToCart(DetallePedidoDTO detallePedidoDTO) throws Exception {
        try {
            DetallePedido detallePedido = DetallePedido.builder()
                    .cantidad(detallePedidoDTO.getCantidad())
                    .articuloManufacturado(articuloManufacturadoService.findById(detallePedidoDTO.getIdArticuloManufacturado()))
                    .build();

            return detallePedidoRepository.save(detallePedido);

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
