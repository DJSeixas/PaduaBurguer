
import Header from '../../components/Header'
import Search from '../../components/Search'
import OptionsGrid from '../../components/OptionsGrid'
import { Button, Container } from './styles'
import { StatusBar } from 'expo-status-bar'

const Home = ({navigation}) => {
    return (
        <Container>
            <Header />
            <Search />
            <OptionsGrid />
            <StatusBar style="auto" />
        </Container>
    )
}

export default Home