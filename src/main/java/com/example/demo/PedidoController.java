package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();

    @GetMapping("/")
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    @GetMapping("/{id}")
    public Pedido encontrarPedidoPorId(@PathVariable int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    @PostMapping("/")
    public Pedido adicionarPedido(@RequestBody Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido editarPedido(@PathVariable int id, @RequestBody Pedido pedidoAtualizado) {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getId() == id) {
                pedidos.set(i, pedidoAtualizado);
                return pedidoAtualizado;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedidos.remove(pedido);
                return;
            }
        }
    }
}
