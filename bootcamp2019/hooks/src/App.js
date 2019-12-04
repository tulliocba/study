import React, {useState} from 'react';

function App() {
  const [techs, setTechs] = useState(['ReactJs', 'ReactNative'] );

  function handleAdd() {
    setTechs([...techs, 'Node.js']);
  }

  return (
    <>
      <ul>
        {techs.map((t) => (<li key={t}>{t}</li>))}
      </ul>
      <button type="button" onClick={handleAdd } >Adicionar</button>
    </>
  );
}

export default App;
