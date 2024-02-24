<template>
  <svg>
    <line stroke="black" x1="150" y1="0" x2="150" y2="300"/>
    <line stroke="black" x1="0" y1="150" x2="300" y2="150"/>
    <polyline stroke="black" fill="none" points="147, 5 150, 0 153, 5"/>
    <polyline stroke="black" fill="none" points="295, 147 300, 150 295, 153"/>
    <line v-for="line in lines" stroke="black"
          v-bind:x1="line.x1"
          v-bind:y1="line.y1"
          v-bind:x2="line.x2"
          v-bind:y2="line.y2"/>
    <text v-for="title in titles"
          v-bind:x="title.x"
          v-bind:y="title.y">
      {{title.title}}
    </text>
  </svg>
</template>

<script>
export default {
  name: 'Axes',
  data() {
    return {
      lines: [],
      titles: []
    }
  },
  mounted() {
    for (let i = 1; i < 10; i++) {
      if (i !== 5) {
        this.lines.push({x1: i * 30, y1: 147, x2: i * 30, y2: 153});
        this.lines.push({x1: 147, y1: i * 30, x2: 153, y2: i * 30});
        this.titles.push({title: (i - 5), x: i * 30, y: 145});
        this.titles.push({title: (i - 5), x: 155 , y: i * 30});
      }
    }
  }
}
</script>