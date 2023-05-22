import { FontAwesomeIcon } from "@fortawesome/react-native-fontawesome"
import { Button, ButtonView, Container, ListContainer, PagContainer, PressableContainer, PressableTitle, Text, TextContainer, TextEntrega, TextWhite, Title } from "./styles"
import { faHome } from "@fortawesome/free-solid-svg-icons"
import BagCard from "../../components/BagCard"


const BagScreen = ({navigation}) => {
    return (
        <Container>
            <TextContainer>
            <PressableTitle onPress={() => navigation.navigate('Home')}>
            <FontAwesomeIcon size={30} icon={ faHome } />
            </PressableTitle>   
            <Title>
                Sacola
            </Title>
            </TextContainer>

            <ListContainer>
                <BagCard />
                <BagCard />
                <BagCard />
            </ListContainer>

            <TextEntrega>
                Endereço de Entrega: gsfdgsdhgsfhfghfsgshsdfhsgf
            </TextEntrega>

            <PagContainer>
                <Text>Forma de Pagamento?</Text>
                <ButtonView>
                    <Button>
                        <TextWhite>Cartão</TextWhite>
                    </Button>
                    <Button>
                        <TextWhite>Dinheiro</TextWhite>
                    </Button>
                </ButtonView>
            </PagContainer>

            <PressableContainer onPress ={() => navigation.navigate('ConfirmScreen')}>
                <Title>
                    Prosseguir
                </Title>
            </PressableContainer>

        </Container>
    )
}

export default BagScreen
