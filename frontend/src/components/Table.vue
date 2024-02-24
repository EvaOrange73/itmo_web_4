<template>
  <table>
    <thead>
    <tr>
      <th>X</th>
      <th>Y</th>
      <th>R</th>
      <th>Результат</th>
      <th>Время отправки запроса</th>
      <th>Время работы скрипта</th>
    </tr>
    </thead>
    <tbody id="table">
    <tr v-for="point in points">
      <td>{{ point.x }}</td>
      <td>{{ point.y }}</td>
      <td>{{ point.r }}</td>

      <td v-if="point.result" class="green"> Точка попадает в область</td>
      <td v-else class="red"> Точка не попадает в область</td>

      <td>{{ point.requestTime }}</td>
      <td>{{ point.processTime }}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'Table',
  props: ['points'],
  mounted() {
    this.$root.getPoints();
  }
}
</script>

<style scoped>
table {
  width: 100%;
  margin-bottom: 20px;
  border: 1px solid #dddddd;
  border-collapse: collapse;
}

th {
  font-weight: bold;
  padding: 5px;
  background: #efefef;
  border: 1px solid #dddddd;
}

td {
  border: 1px solid #dddddd;
  padding: 10px;
}

.green {
  color: green;
}

.red {
  color: red;
}
</style>