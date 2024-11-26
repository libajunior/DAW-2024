const arrayValor = [1, 2, 3, 4, 5, 6];

const arrayObjects = [
  { valor1: 1, valor2: '13/11/2024', valor3: 'três' },
  { valor1: 3, valor2: '13/11/2024', valor3: 'três' },
]

console.table(arrayObjects);

arrayObjects.push({ valor1: 4, valor2: '13/11/2024', valor3: 'quarto' })

console.table(arrayObjects);