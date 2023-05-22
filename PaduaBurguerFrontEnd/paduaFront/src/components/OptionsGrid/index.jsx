import { Container, Button } from "./styles"
import Options from '../Options';
import { artesanal, quadrado, tradicional, porcao, bebida } from "../../assets/Images";

import { useNavigation } from "@react-navigation/native";
import { Pressable } from "react-native";

const OptionsGrid = () => {

    const nav = useNavigation()

    return (
        <Container>
            <Pressable onPress={() => nav.navigate('ItensScreen', { title: 'Artesanais' })}>
            <Options title="Lanches Artesanais"  img={artesanal}/>
            </Pressable>
            <Pressable onPress={() => nav.navigate('ItensScreen', { title: 'Tradicionais' })}>
            <Options title="Lanches Tradicionais" img={tradicional}/>
            </Pressable>
            <Pressable onPress={() => nav.navigate('ItensScreen', { title: 'Quadrados' })}>
            <Options title="Lanches Quadrados" img={quadrado}/>
            </Pressable>
            <Pressable onPress={() => nav.navigate('ItensScreen', { title: 'Veganos' })}>
            <Options title="Lanches Veganos" img={quadrado}/>
            </Pressable>
            <Pressable onPress={() => nav.navigate('ItensScreen', { title: 'Porções' })}>
            <Options title="Porções" img={porcao}/>
            </Pressable>
            <Pressable onPress={() => nav.navigate('ItensScreen', { title: 'Bebidas' })}>
            <Options title="Bebidas" img={bebida}/>
            </Pressable>
        </Container>
    )
}

export default OptionsGrid