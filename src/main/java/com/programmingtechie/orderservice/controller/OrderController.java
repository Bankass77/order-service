package com.programmingtechie.orderservice.controller;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@RefreshScope
public class OrderController {

    private final OrderService orderService;

    /**
     * Crée une nouvelle commande en utilisant les détails fournis dans l'objet OrderRequest.
     * <p>
     * Cette méthode est mappée à une requête HTTP POST et renvoie un statut HTTP 201 (CREATED) si la commande est placée avec succès.
     * </p>
     *
     * @param orderRequest
     *         l'objet OrderRequest contenant les informations nécessaires pour créer une nouvelle commande. Cet objet inclut des détails tels que
     *         l'identifiant, le numéro de commande, le code SKU, le prix et la quantité.
     * @return une chaîne de caractères indiquant que la commande a été placée avec succès.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequest orderRequest) {

        orderService.placeOrder(orderRequest);
        return "Order Placed successfully";

    }

}
