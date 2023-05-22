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
    background-color: #FFF;
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
    height: 75%;
    border-radius: 10px;
    align-items: center;
    justify-content: flex-start;
    margin-top: 20px;
    overflow: hidden;
`

export const PressableContainer = styled.Pressable`
    width: 84%;
    height: 80px;
    border-radius: 16px;
    background-color: #FFF;
    flex-direction: row;
    align-items: center;
    justify-content: space-evenly;
    border: black;
    background-color: #FEB904;
`