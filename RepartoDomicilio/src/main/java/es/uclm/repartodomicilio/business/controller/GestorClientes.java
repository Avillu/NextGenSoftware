package es.uclm.repartodomicilio.business.controller;

import es.uclm.repartodomicilio.business.entity.Cliente;
import es.uclm.repartodomicilio.business.entity.Restaurante;
import es.uclm.repartodomicilio.business.persistence.ClienteDAO;
import es.uclm.repartodomicilio.business.persistence.RestauranteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GestorClientes {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private RestauranteDAO restauranteDAO;

    @GetMapping("/registro/cliente")
    public String registroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registroCliente";
    }

    @PostMapping("/registro/cliente")
    public String registrarCliente(@ModelAttribute Cliente cliente, Model model) {
        // Verificamos si ya existe un cliente con el mismo DNI o correo
        if (clienteDAO.existsByDni(cliente.getDni())) {
            model.addAttribute("error", "El DNI ya está registrado.");
            model.addAttribute("cliente", cliente); // Mantener los datos del formulario
            return "registroCliente"; // Volver al formulario con el mensaje de error
        }

        if (clienteDAO.existsByEmail(cliente.getEmail())) {
            model.addAttribute("error", "El correo electrónico ya está registrado.");
            model.addAttribute("cliente", cliente); // Mantener los datos del formulario
            return "registroCliente"; // Volver al formulario con el mensaje de error
        }

        // Guardamos el cliente
        Cliente savedCliente = clienteDAO.save(cliente);
        model.addAttribute("cliente", savedCliente);
        return "registradoCliente";
    }

    // Método para la vista de favoritos
    @GetMapping("/favoritos")
    public String mostrarFavoritos() {
        return "VistaFavoritos";
    }

    @PostMapping("/favoritos")
    public String mostrarFavs() {
        return "VistaFavoritos";
    }

    /**
     * Listar restaurantes con funcionalidad de búsqueda flexible
     * @param search Término de búsqueda opcional
     * @param model Modelo para enviar datos a la vista
     * @return Nombre de la vista
     */
    @GetMapping("/Cliente")
    public String listarRestaurantes(
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            Model model) {
        List<Restaurante> restaurantes;
        if (search.isEmpty()) {
            restaurantes = restauranteDAO.findAll(); // Obtener todos los restaurantes si no hay búsqueda
        } else {
            restaurantes = restauranteDAO.findBySearchTerm(search); // Buscar por término
        }
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("search", search); // Mantener el término de búsqueda en la vista
        return "VistaCliente";
    }

    @PostMapping("/Cliente")
    public String listarRestaurantesPost(
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            Model model) {
        List<Restaurante> restaurantes;
        if (search.isEmpty()) {
            restaurantes = restauranteDAO.findAll();
        } else {
            restaurantes = restauranteDAO.findBySearchTerm(search);
        }
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("search", search);
        return "VistaCliente";
    }
}
