import { Header, ShoppingCart } from './components';
import { Container } from 'react-bootstrap';

function App() {
  return (
    <Container style={{ maxWidth: '600px' }}>
      <Header title='AI Shopping Cart' />
      <ShoppingCart />
    </Container>
  );
}

export default App;
