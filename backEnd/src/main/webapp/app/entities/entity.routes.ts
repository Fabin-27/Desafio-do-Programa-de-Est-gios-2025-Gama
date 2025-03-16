import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'aluno',
    data: { pageTitle: 'backEndApp.backEndAluno.home.title' },
    loadChildren: () => import('./backEnd/aluno/aluno.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
