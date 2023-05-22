
import { Container, PressableTitle, ItemContainer, ItemText, ListContainer, TitleContainer, Title, TextContainer, PressableContainer } from "./styles"

import { FontAwesomeIcon } from "@fortawesome/react-native-fontawesome"
import { faArrowLeft, faBasketShopping } from "@fortawesome/free-solid-svg-icons"
import ProductCard from "../../components/ProductCard"


const ItensScreen = ({route, navigation}) => {

    const { title } = route.params

    return (
        <Container>
            <TextContainer>
            <PressableTitle onPress={() => navigation.goBack()}>
            <FontAwesomeIcon size={30} icon={ faArrowLeft } />
            </PressableTitle>   
            <Title>
                {title}
            </Title>
            </TextContainer>

            <ListContainer>
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
            </ListContainer>
            
            <PressableContainer onPress ={() => navigation.navigate('BagScreen')}>
                <Title>Adicionar a Sacola</Title>
                <FontAwesomeIcon size={30} icon={ faBasketShopping } />
            </PressableContainer>
            
        </Container>  
    )
}

export default ItensScreen