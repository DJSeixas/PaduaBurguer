import { useNavigation } from "@react-navigation/native"
import { Container, Title } from "./styles"
import { Image } from "react-native"

const Options = ({ title, img }) => {

    return(
        <Container>
            <Title>{title}</Title>
            <Image source ={
            img 
        }
        style={{ width: 164, height: 180 }}
        />
        </Container>
    )
}

export default Options