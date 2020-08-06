<template>
  <div>
    <h1>Todo Footer</h1>
    <button v-on:click="clearTodo">Delete All</button>
  </div>
</template>

<script>
export default {
  methods: {
    clearTodo () {
      console.log('clearTodo')
      this.$emit('removeAll')
    }
  }
}
</script>

<style scoped>
  div {
    background-color: #465598
  }

</style>
