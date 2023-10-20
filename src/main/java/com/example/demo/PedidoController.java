package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();
    private Long proximoId = 1L;

    @GetMapping("/")
    public List<Pedido> listarPedidos() {
        return pedidos;

    }

    @GetMapping("/{id}")
    public Pedido encontrarPedidoPorId(@PathVariable Long id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }
        return null;
    }

    @PostMapping("/")
    public Pedido adicionarPedido(@RequestBody Pedido pedido) {
        pedido.setId(proximoId++);
        pedidos.add(pedido);
        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido editarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getId().equals(id)) {
                pedidoAtualizado.setId(id);
                pedidos.set(i, pedidoAtualizado);
                return pedidoAtualizado;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        pedidos.removeIf(pedido -> pedido.getId().equals(id));
    }
}
