package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();


    @GetMapping("/")
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @GetMapping("/{id}")
    public Produto encontrarProdutoPorId(@PathVariable int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }


    @PostMapping("/")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public Produto editarProduto(@PathVariable int id, @RequestBody Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId() == id) {
                produtos.set(i, produtoAtualizado);
                return produtoAtualizado;
            }
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                return;
            }
        }
    }
}
