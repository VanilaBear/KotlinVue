import store from './store'
const server_url = 'http://localhost:8000/'


async function makeRequest(action, method = "GET", payload = {}) {
    let url = server_url + action
    const options = {
        method: method,
        headers: { 'content-type': 'application/json' },
        mode: 'cors'
    };
    if (store.state.authorized) {
        options.headers['authorization'] = store.state.authorizationHeader
    }
    if (method != "GET") {
        options.body = JSON.stringify(payload);
    }
    return fetch(url, options)
}

export default makeRequest;