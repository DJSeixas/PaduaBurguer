
import { createNativeStackNavigator } from '@react-navigation/native-stack'

const { Screen, Navigator } = createNativeStackNavigator()

import  Home from '../screens/Home'
import ItensScreen from '../screens/ItensScreen'
import BagScreen from '../screens/BagScreen'
import ConfirmScreen from '../screens/ConfirmScreen'
import ProfileScreen from '../screens/ProfileScreen'
import LoginScreen from '../screens/LoginScreen'

export function StackRoutes(){
    return (
        <Navigator
        screenOptions={{
            headerShown: false
        }}
        >
            <Screen 
            name="Home"
            component={Home}
            />
            <Screen 
            name='ItensScreen'
            component={ItensScreen}
            />
            <Screen 
            name='BagScreen'
            component={BagScreen}
            />
            <Screen 
            name='ConfirmScreen'
            component={ConfirmScreen}
            />
            <Screen 
            name='ProfileScreen'
            component={ProfileScreen}
            />
            <Screen 
            name='LoginScreen'
            component={LoginScreen}
            />
        </Navigator>
    )
}
