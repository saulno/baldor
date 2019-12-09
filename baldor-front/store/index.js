export const state = () => ({
    name: ""
})

export const mutations = {
    updateName(state, name) {
        state.name = name;
    }
}

export const getters = {
    get(state) {
        return state.name
    }
}