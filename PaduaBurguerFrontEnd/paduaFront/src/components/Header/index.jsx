import { Container, TextContainer } from "./styles"
import { Image, Pressable } from "react-native"
import { FontAwesomeIcon } from "@fortawesome/react-native-fontawesome"
import { faUser, faBasketShopping } from "@fortawesome/free-solid-svg-icons"
import { logo } from "../../assets/Images"
import { useNavigation } from "@react-navigation/native"
import BagScreen from "../../screens/BagScreen"

const Header = () => {

    const nav = useNavigation()

    return(

    <Container>
        <Pressable onPress={() => nav.navigate('ProfileScreen')}>
        <FontAwesomeIcon size={30} icon={ faUser } />
        </Pressable>
        <Image source ={logo}
        style={{ width: 160, height: 160 }}
        />
        <Pressable onPress={() => nav.navigate('BagScreen')}>
        <FontAwesomeIcon size={30} icon={ faBasketShopping } />
        </Pressable>
    </Container>

    )
}

export default Header