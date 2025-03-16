import { IMeta, NewMeta } from './meta.model';

export const sampleWithRequiredData: IMeta = {
  id: 17187,
  area: 'HUMANAS',
  valor: 8277,
};

export const sampleWithPartialData: IMeta = {
  id: 15622,
  area: 'NATUREZA',
  valor: 14505,
};

export const sampleWithFullData: IMeta = {
  id: 32703,
  area: 'LINGUAGENS',
  valor: 406,
};

export const sampleWithNewData: NewMeta = {
  area: 'HUMANAS',
  valor: 27853,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
