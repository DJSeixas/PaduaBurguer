import styled from "styled-components";

export const Container = styled.View`
    flex: 1;
    align-items: center;
    justify-content: flex-start;
    padding: 40px 0;
    background-color: #FCFCF6;
`
//Title
export const TextContainer = styled.View`
    flex-direction: row;
    align-items: center;
    justify-content: space-around;
    width: 94%;
`

export const Title = styled.Text`
    font-size: 40px;
`

//Infos
export const Info = styled.View`
    align-items: center;
    justify-content: flex-start;
    width: 84%;
    height: 80%;
    background-color: #FFF;
    border-radius: 20px;
    border: #F2F2F2;
    margin: 16px 0;
    padding-top: 20px;
`
export const BackButton = styled.Pressable`
    width: 60%;
    height: 60px;
    border-radius: 60px;
    align-items: center;
    justify-content: center;
    border: black;
    background-color: #F2F2F2;
    position: absolute;
    bottom: 20px;
`
export const TextButton = styled.Text`
    font-size: 20px;
    font-weight: 800;
    color: #C73E3E;
`

//Info e confirmar
export const Text = styled.Text`
    font-size: 20px;
    font-weight: 800;
`
//Confirmar
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