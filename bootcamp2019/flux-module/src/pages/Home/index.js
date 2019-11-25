import React from "react";
import { MdAddShoppingCart } from "react-icons/md";

import { ProductList } from "./styles";

export default function Home() {
    return (
        <ProductList>
            <li>
                <img
                    src="https://static.netshoes.com.br/produtos/tenis-nike-revolution-5-masculino/26/HZM-1731-026/HZM-1731-026_detalhe2.jpg?ims=326x"
                    alt="Tẽnis"
                />
                <strong>Tênis muito legal</strong>
                <span>R$129,90</span>
                <button type="button">
                    <div>
                        <MdAddShoppingCart size={16} color="#FFF">
                            3
                        </MdAddShoppingCart>
                    </div>
                    <span>ADICIONAR AO CARRINHO</span>
                </button>
            </li>
            <li>
                <img
                    src="https://static.netshoes.com.br/produtos/tenis-nike-revolution-5-masculino/26/HZM-1731-026/HZM-1731-026_detalhe2.jpg?ims=326x"
                    alt="Tẽnis"
                />
                <strong>Tênis muito legal</strong>
                <span>R$129,90</span>
                <button type="button">
                    <div>
                        <MdAddShoppingCart size={16} color="#FFF">
                            3
                        </MdAddShoppingCart>
                    </div>
                    <span>ADICIONAR AO CARRINHO</span>
                </button>
            </li>
            <li>
                <img
                    src="https://static.netshoes.com.br/produtos/tenis-nike-revolution-5-masculino/26/HZM-1731-026/HZM-1731-026_detalhe2.jpg?ims=326x"
                    alt="Tẽnis"
                />
                <strong>Tênis muito legal</strong>
                <span>R$129,90</span>
                <button type="button">
                    <div>
                        <MdAddShoppingCart size={16} color="#FFF">
                            3
                        </MdAddShoppingCart>
                    </div>
                    <span>ADICIONAR AO CARRINHO</span>
                </button>
            </li>
            <li>
                <img
                    src="https://static.netshoes.com.br/produtos/tenis-nike-revolution-5-masculino/26/HZM-1731-026/HZM-1731-026_detalhe2.jpg?ims=326x"
                    alt="Tẽnis"
                />
                <strong>Tênis muito legal</strong>
                <span>R$129,90</span>
                <button type="button">
                    <div>
                        <MdAddShoppingCart size={16} color="#FFF">
                            3
                        </MdAddShoppingCart>
                    </div>
                    <span>ADICIONAR AO CARRINHO</span>
                </button>
            </li>
            <li>
                <img
                    src="https://static.netshoes.com.br/produtos/tenis-nike-revolution-5-masculino/26/HZM-1731-026/HZM-1731-026_detalhe2.jpg?ims=326x"
                    alt="Tẽnis"
                />
                <strong>Tênis muito legal</strong>
                <span>R$129,90</span>
                <button type="button">
                    <div>
                        <MdAddShoppingCart size={16} color="#FFF">
                            3
                        </MdAddShoppingCart>
                    </div>
                    <span>ADICIONAR AO CARRINHO</span>
                </button>
            </li>
        </ProductList>
    );
}
