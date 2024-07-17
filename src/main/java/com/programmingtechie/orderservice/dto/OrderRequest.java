package com.programmingtechie.orderservice.dto;

import java.math.BigDecimal;

/**
 * Représente une demande de commande contenant les informations nécessaires pour créer ou traiter une commande.
 *
 * @param id
 *         l'identifiant unique de la demande de commande. Il s'agit d'un identifiant de type Long.
 * @param orderNumber
 *         le numéro de commande unique associé à cette demande. Il s'agit d'une chaîne de caractères.
 * @param skuCode
 *         le code SKU (Stock Keeping Unit) de l'article commandé. Il s'agit d'une chaîne de caractères unique identifiant l'article dans le système
 *         d'inventaire.
 * @param price
 *         le prix de l'article commandé. Il s'agit d'un objet BigDecimal représentant le coût unitaire de l'article.
 * @param quantity
 *         la quantité de l'article commandé. Il s'agit d'un entier représentant le nombre d'unités de l'article.
 */
public record OrderRequest(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity) {

}
