import dayjs from 'dayjs/esm';

import { IAluno, NewAluno } from './aluno.model';

export const sampleWithRequiredData: IAluno = {
  id: 8806,
  nome: 'boo tomorrow',
  email: 'x07@i.dxs.e.XG12Ty.tEl',
  dtNascimento: dayjs('2025-03-15'),
  cpf: '670.596.439-70',
};

export const sampleWithPartialData: IAluno = {
  id: 2189,
  nome: 'insecure supposing untimely',
  email: 'L3S79@Shr.7i8fH.Rf',
  dtNascimento: dayjs('2025-03-16'),
  cpf: '793.854971-37',
};

export const sampleWithFullData: IAluno = {
  id: 25732,
  nome: 'oof near likewise',
  email: 'HH@VhqrxH.7PjG.3.8g.vVR13.xk_zN.nx',
  dtNascimento: dayjs('2025-03-15'),
  cpf: '620.254.101-56',
};

export const sampleWithNewData: NewAluno = {
  nome: 'energetically yet webbed',
  email: 'ruKYi@js3FK.m.JskD.z.j0v',
  dtNascimento: dayjs('2025-03-16'),
  cpf: '160983.591-25',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
