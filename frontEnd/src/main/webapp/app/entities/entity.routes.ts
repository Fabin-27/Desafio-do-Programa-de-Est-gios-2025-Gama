import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'aluno',
    data: { pageTitle: 'frontEndApp.backEndAluno.home.title' },
    loadChildren: () => import('./backEnd/aluno/aluno.routes'),
  },
  {
    path: 'meta',
    data: { pageTitle: 'frontEndApp.backEndMeta.home.title' },
    loadChildren: () => import('./backEnd/meta/meta.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
