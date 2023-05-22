import { FontAwesomeIcon } from "@fortawesome/react-native-fontawesome"
import { ItemContainer, ItemText, QtContainer } from "./styles"
import { faMinus, faPlus } from "@fortawesome/free-solid-svg-icons"


const ProductCard = () => {
    return (
        <ItemContainer>
            <ItemText>
                Yankee Bacon
            </ItemText>

            <QtContainer>
            <FontAwesomeIcon size={25} icon={ faMinus } />
            <ItemText>0</ItemText>
            <FontAwesomeIcon size={25} icon={ faPlus } />
            </QtContainer>         
        </ItemContainer>
    )
}

export default ProductCard