import React from 'react';
import logo from '../../assets/logo.svg';
import {Link} from 'react-router-dom';

export default function SignIn() {
  return (
    <>
      <img src={logo} alt="GoBarber"/>

      <form>
        <input type="email" placeholder="Seu e-mail"/>
        <input type="password" placeholder="Sua senha"/>

        <button type="submit">Acessar </button>
        <Link to="/register">Criar conta gratuita</Link>
      </form>
    </>
  );
}
