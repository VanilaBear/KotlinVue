import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
const store = new Vuex.Store({
    state: {
        authorized: false,
        authorizationHeader:'',
        isAdmin:false,
        name: '',
        messages: [
            {
                _id: 14,
                msg: 'Hello world',
                author: 'Anton',
                aproved: true,
                date: Date.now()
            },
            {
                _id: 25,
                msg: 'Hi',
                author: 'Vasya',
                aproved: false,
                date: Date.now()
            }
        ]
    },
    mutations: {
        setauthorizationHeader(state,value){
            state.authorizationHeader = value
        },
        setAuthorized(state, value) {
            state.authorized = value
        },
        setName(state, value) {
            state.name = value
        },
        setMessages(state,value){
            state.messages=value
        },
        setIsAdmin(state,value){
            state.isAdmin = value
        },
        addMessage(state, payload) {
            state.messages.push({
                msg: payload,
                author: state.name,
                aproved: false,
                date: Date.now()
            })
        }
    },

})
export default store;