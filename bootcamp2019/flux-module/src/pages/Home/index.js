import React, { Component } from "react";
import { MdAddShoppingCart } from "react-icons/md";
import { connect } from "react-redux";
import { ProductList } from "./styles";
import { formatPrice } from "../../util/format";
import api from "../../services/api";

class Home extends Component {
    // eslint-disable-next-line react/state-in-constructor
    state = {
        produtcs: []
    };

    async componentDidMount() {
        const response = await api.get("/products");
        const data = response.data.map(product => ({
            ...product,
            priceFormatted: formatPrice(product.price)
        }));
        this.setState({ produtcs: data });
    }

    handleAddProduct = product => {
        const { dispatch } = this.props;
        dispatch({
            type: "ADD_TO_CART",
            product
        });
    };

    render() {
        const { produtcs } = this.state;
        return (
            <ProductList>
                {produtcs.map(product => (
                    <li key={product.id}>
                        <img src={product.image} alt={product.title} />
                        <strong>{product.title}</strong>
                        <span>{product.priceFormatted}</span>
                        <button
                            type="button"
                            onClick={() => this.handleAddProduct(product)}
                        >
                            <div>
                                <MdAddShoppingCart size={16} color="#FFF">
                                    3
                                </MdAddShoppingCart>
                            </div>
                            <span>ADICIONAR AO CARRINHO</span>
                        </button>
                    </li>
                ))}
            </ProductList>
        );
    }
}

export default connect()(Home);
