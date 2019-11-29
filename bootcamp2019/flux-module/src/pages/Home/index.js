import React, { Component } from "react";
import { MdAddShoppingCart } from "react-icons/md";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import { ProductList } from "./styles";
import { formatPrice } from "../../util/format";
import api from "../../services/api";
import * as CartActions from "../../store/modules/cart/actions";

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
        const { addToCart } = this.props;
        addToCart(product);
    };

    render() {
        const { produtcs } = this.state;
        const { amount } = this.props;
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
                                <MdAddShoppingCart size={16} color="#FFF" />{" "}
                                {amount[product.id] || 0}
                            </div>
                            <span>ADICIONAR AO CARRINHO</span>
                        </button>
                    </li>
                ))}
            </ProductList>
        );
    }
}

const mapDispatchToProps = dispatch =>
    bindActionCreators(CartActions, dispatch);

const mapStateToProps = state => ({
    amount: state.cart.reduce((amount, product) => {
        amount[product.id] = product.amount;
        return amount;
    }, {})
});
export default connect(mapStateToProps, mapDispatchToProps)(Home);
