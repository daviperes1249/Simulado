package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    private Long proximoId = 1L;


    @GetMapping("/")
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @GetMapping("/{id}")
    public Produto encontrarProdutoPorId(@PathVariable Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }


    @PostMapping("/")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }


    @PutMapping("/{id}")
    public Produto editarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId().equals(id)) {
                produtoAtualizado.setId(id);
                produtos.set(i, produtoAtualizado);
                return produtoAtualizado;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }
}
