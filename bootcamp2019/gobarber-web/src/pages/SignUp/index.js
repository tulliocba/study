import React from 'react';
import logo from '../../assets/logo.svg';
import {Link} from 'react-router-dom';
import {Form, Input} from '@rocketseat/unform';
import * as Yup from 'yup';

const schema = Yup.object().shape({
  nome: Yup.string().required('O nome é obrigatório'),
  email: Yup.string().email('Insira um e-mail válido').required( 'O E-mail é obrigatório'),
  password: Yup.string().min(6, 'A senha precisa de no mínimo 6 caracteres').required('A senha é obrigatória'),
});


export default function SignUp() {
  function handleSubmit(data) {
    console.tron.log(data);
  }

  return (
    <>
      <img src={logo} alt="GoBarber"/>

      <Form schema={schema} onSubmit={handleSubmit}>
        <Input name="nome" placeholder="Nome completo"/>
        <Input name="email" type="email" placeholder="Seu e-mail"/>
        <Input name="password" type="password" placeholder="Sua senha"/>

        <button type="submit">Criar conta </button>
        <Link to="/register">Já tenho login</Link>
      </Form>
    </>
  );
}
