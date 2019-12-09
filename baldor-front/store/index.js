export const state = () => ({
    name: "",
    progreso: -1
})

export const mutations = {
    updateName(state, name) {
        state.name = name;
    },
    updateProgreso(state, p) {
        state.progreso = p;
    }
}

export const getters = {
    get(state) {
        return state
    }
}