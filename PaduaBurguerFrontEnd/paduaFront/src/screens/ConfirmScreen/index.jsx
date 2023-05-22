import { FontAwesomeIcon } from "@fortawesome/react-native-fontawesome"
import { BackButton, Container, Info, PressableContainer, Text, TextButton, TextContainer, Title } from "./styles"
import { faBurger } from "@fortawesome/free-solid-svg-icons"


const ConfirmScreen = ({navigation}) => {
    return (
        <Container>

            <TextContainer>
            <FontAwesomeIcon size={30} icon={ faBurger } color="#ffb804" />
            <Title>
                Pádua Burguer
            </Title>
            <FontAwesomeIcon size={30} icon={ faBurger } color="#ffb804" />
            </TextContainer>

            <Info>
                <Text>Verifique seu pedido</Text>
                <BackButton onPress={() => navigation.goBack()}>
                    <TextButton>Cancelar</TextButton>
                </BackButton>
            </Info>

            <PressableContainer>
                <Text>Confirmar Pedido</Text>
            </PressableContainer>
        </Container>
    )
}

export default ConfirmScreen