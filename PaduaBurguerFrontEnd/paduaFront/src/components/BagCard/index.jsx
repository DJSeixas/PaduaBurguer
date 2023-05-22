import { FontAwesomeIcon } from "@fortawesome/react-native-fontawesome"
import { Container, Text } from "./styles"
import { faXmark } from "@fortawesome/free-solid-svg-icons"



const BagCard = () => {
    return(
        <Container>
            <Text>
                Pedido x 2
            </Text>

            <FontAwesomeIcon size={35} icon={ faXmark } color="red" />
        </Container>
    )
}

export default BagCard