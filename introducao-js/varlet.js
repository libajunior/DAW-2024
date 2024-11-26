const exibeMensagemVar = () => {
  var msgForaIF = 'Brasil';

  if (true) {
    var msgDentroIF = 'Argentina';
    console.log(msgDentroIF)
  }

  console.log('1 ', msgForaIF);
  console.log('2 ', msgDentroIF);
}

exibeMensagemVar();

const exibeMensagemLet = () => {
  let msgForaIF = 'Brasil';

  if (true) {
    let msgDentroIF = 'Argentina';
    console.log(msgDentroIF)
  }

  console.log('1 ', msgForaIF);
  console.log('2 ', msgDentroIF);
}

exibeMensagemLet();