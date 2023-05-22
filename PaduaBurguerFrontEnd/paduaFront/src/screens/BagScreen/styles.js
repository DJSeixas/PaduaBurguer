import styled from "styled-components";

export const Container = styled.View`
    flex: 1;
    align-items: center;
    justify-content: flex-start;
    padding: 60px 0;
    background-color: #FCFCF6;
`
//Title
export const TextContainer = styled.View`
    width: 84%;
    height: 80px;
    border-radius: 16px;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    border: black;
    background-color: #FEB904;
`

export const PressableTitle = styled.Pressable`
    position: absolute;
    padding-right: 260px;
`

export const Title = styled.Text`
    font-weight: 800;
    font-size: 20px;
`
//List
export const ListContainer = styled.View`
    width: 84%;
    height: 50%;
    border-radius: 10px;
    align-items: center;
    justify-content: flex-start;
    margin-top: 20px;
    overflow: hidden;
`
//EndereçoDeEntrega
export const TextEntrega = styled.Text`
    font-size: 15px;
    width: 84%;
    height: 14%;
    margin: 10px 0;
`

//FormaDePagamento
export const PagContainer = styled.View`
    width: 84%;
    height: 80px;
    border-radius: 16px;
    background-color: #FFF;
    align-items: center;
    justify-content: flex-start;
    border: black;
    background-color: #FEB904;
    overflow: hidden;
    margin-bottom: 10px;
`

export const Text = styled.Text`
    font-size: 15px;
`

export const ButtonView = styled.View`
    width: 100%;
    height: 60%;
    flex-direction: row;
    align-items: center;
    justify-content: space-around;
    margin-top: 4px;
`
export const Button = styled.Pressable`
    width: 36%;
    height: 100%;
    border-radius: 20px;
    background-color: #000;
    align-items: center;
    justify-content: center;
`

export const TextWhite = styled.Text`
    font-size: 15px;
    color: #FFF;
`

//Prosseguir
export const PressableContainer = styled.Pressable`
    width: 84%;
    height: 80px;
    border-radius: 16px;
    background-color: #FFF;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    border: black;
    background-color: #FEB904;
`