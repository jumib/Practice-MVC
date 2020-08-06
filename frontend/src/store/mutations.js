import {
  successGenRandNum,
  failGenRandNum,
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL
} from './mutation-types'

export default {
  increment (state) {
    state.count++
  },
  decrement (state) {
    state.count--
  },
  [successGenRandNum] (state, payload) {
    state.random = payload
  },
  [failGenRandNum] () {
    alert('망했어요')
  },
  [ADD_TODO] (state, todoItems) {
    state.todoItems.push(todoItems)
  },
  [REMOVE_TODO] (state, idx) {
    state.todoItems.splice(idx, 1)
  },
  [CLEAR_ALL] (state) {
    state.todoItems = []
  }
}
