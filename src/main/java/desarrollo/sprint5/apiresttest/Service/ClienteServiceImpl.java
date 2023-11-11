package desarrollo.sprint5.apiresttest.Service;

import desarrollo.sprint5.apiresttest.DTO.ClienteDTO;
import desarrollo.sprint5.apiresttest.Entity.Cliente;
import desarrollo.sprint5.apiresttest.Jwt.JwtService;
import desarrollo.sprint5.apiresttest.Repository.BaseRepository;
import desarrollo.sprint5.apiresttest.Repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    //Agregado para buscar el cliente atraves del usuario
    @Autowired
    private JwtService jwtService; // Inyecta tu servicio JwtService

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Cliente searchById(Long idCliente) throws Exception {
        try {
            Cliente cliente = clienteRepository.searchById(idCliente);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ClienteDTO showProfile(String token) throws Exception{
        try {
            // Obtiene el token JWT de la solicitud HTTP.
            String jwtToken = token.substring(7);
            // Extrae el username del usuario del token JWT utilizando tu servicio JwtService.
            String username = jwtService.getUsernameFromToken(jwtToken);
            Cliente cliente = clienteRepository.findClienteByUsername(username);
            System.out.println("!!!!!!!!USERNAME USADO: "+username);

            ModelMapper modelMapper = new ModelMapper();
            ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);

            return clienteDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ClienteDTO updateCliente(String token, ClienteDTO clienteActualizado) throws Exception {
        try {
            String jwtToken = token.substring(7);
            String username = jwtService.getUsernameFromToken(jwtToken);
            Cliente clienteExistente = clienteRepository.findClienteByUsername(username);

            //System.out.println("!!!!!!!!nombre clienteActualizado " + clienteActualizado.getNombre());
            //System.out.println("!!!!!!!!apellido clienteActualizado " + clienteActualizado.getApellido());

            // Actualizar los campos del cliente con los nuevos datos
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setMail(clienteActualizado.getMail());
            clienteExistente.setFechaHoraModificacionCliente(LocalDate.now());

            // Guardar el cliente actualizado en la base de datos
            Cliente clienteActualizadoEnBaseDeDatos = clienteRepository.save(clienteExistente);

            ModelMapper modelMapper = new ModelMapper();
            ClienteDTO clienteDTO = modelMapper.map(clienteActualizadoEnBaseDeDatos, ClienteDTO.class);

            return clienteDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



}
